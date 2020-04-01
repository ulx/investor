package ru.sberinvestor.dashboard

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.test.KoinTest
import ru.sberbank.network.NetResult
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.network.entity.Asset
import ru.sberbank.network.entity.Dictionaries
import ru.sberbank.network.entity.Resp
import ru.sberbank.storage.dao.AssetDao
import ru.sberbank.storage.entity.AssetDb
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

internal class DashboardRepositoryTest : KoinTest {

    private val dao = mockk<AssetDao>(relaxed = true)
    private val net = mockk<InvestorServiceExecutor>(relaxed = true)
    private val repository = DashboardRepository(net, dao)
    private lateinit var dictionaries: Dictionaries
    private val testDispatcher = TestCoroutineDispatcher()

    @BeforeEach
    fun setUp() {
        val resp = Resp(assets = listOf(Asset(id = "id3333", currency = "rub", issuer_id = 4, type = "type1")))
        dictionaries = Dictionaries(resp = resp)
        coEvery { net.getDictionaries() } returns NetResult.Success(200, dictionaries)

        val assestsDb = listOf(AssetDb(id = "id3333"))
        coEvery { dao.getAlphabetizedWords() } returns assestsDb
        coEvery { dao.insert(any() as AssetDb) } returns 1
        coEvery { dao.insert(any() as List<AssetDb>) } returns listOf(1)
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun getDictionaries() = testDispatcher.runBlockingTest {
        val list = repository.getDictionaries().toList()
        assertTrue(list[0] is InvestorResult.Loading)
        assertTrue(list[1] is InvestorResult.Success)
        assertEquals(2, list.size)
    }


    /**
     * runBlockingTest -  похоже иммет проблемы поэтому заменен на runBlocking
     */
    @Test
    fun getDictionaries2() = runBlocking {
        val result = repository.getDictionaries2()
        assertTrue(result is InvestorResult.Success)
        if (result is InvestorResult.Success) {
            assertEquals(result, InvestorResult.Success(CodeState.OK, dictionaries))
        }

    }
}