package ru.sberinvestor.dashboard

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.jupiter.api.Test

import org.koin.test.KoinTest
import ru.sberbank.network.entity.Dictionaries
import ru.sberinvestor.core.state.InvestorResult


internal class DashboardInteractorTest : KoinTest {


    private val testDispatcher = TestCoroutineDispatcher()

    private val dao = mockk<DashboardRepository>(relaxed = true)

    private val repository = DashboardInteractor(dao)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDictionaries() = runBlockingTest {
        val publisher = flow<InvestorResult<Dictionaries>> {
            emit(InvestorResult.Loading(Dictionaries()))
        }
        coEvery { dao.getDictionaries() }.returns(publisher)
        repository.getDictionaries().onEach {
            assertTrue(it is InvestorResult.Loading)
        }.collect()

        coVerify { dao.getDictionaries() }
    }
}