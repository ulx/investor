package ru.sberinvestor.dashboard

import androidx.lifecycle.SavedStateHandle
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.sberbank.network.entity.Dictionaries
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

internal class DashboardViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    private val handle = SavedStateHandle()
    private val interactor = mockk<DashboardInteractor>()
    private val viewModel = DashboardViewModel(handle, interactor)
    private val count = 10

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        val publisher = flow {
            emit(InvestorResult.Loading(Dictionaries()))
            emit(InvestorResult.Success(CodeState.OK, Dictionaries()))
        }
        coEvery { interactor.getDictionaries() } returns publisher
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun setCount() = runBlockingTest {
        viewModel.setCount(count)
        coVerify(exactly = 1) { interactor.getDictionaries() }
    }

    @Test
    fun getIndex() = runBlockingTest {
        viewModel.setCount(count)
        assertEquals(count, viewModel.getIndex())
    }
}