package br.com.vfsouzatecnologia.businessmanagementback.resource

import br.com.vfsouzatecnologia.businessmanagementback.data.Company
import br.com.vfsouzatecnologia.businessmanagementback.repository.CompanyRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * @author vinicius
 * @since 24/04/19 15:19
 * @version : $<br/>
 *          : $
 *
 */
@WebMvcTest
class CompanyResourceTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var companyRepository: CompanyRepository

    private val companyX = Company("70923128000102", "Empresa X")
    private val companyY = Company("88127559000128", "Empresa Y")

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert find all companies`() {
        println(">> Assert find all companies")
        every { companyRepository.findAll() } returns listOf(companyX, companyY)

        mockMvc.perform(get("/companies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].cnpj").value(companyX.cnpj))
                .andExpect(jsonPath("\$.[1].cnpj").value(companyY.cnpj))
    }

    @Test
    fun `Assert find companies by cnpj`() {
        println(">> Assert find companies by cnpj")
        every { companyRepository.findByIdOrNull(companyX.cnpj) } returns companyX

        mockMvc.perform(get("/companies/${companyX.cnpj}").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.cnpj").value(companyX.cnpj))
    }

    @Test
    fun `Assert insert new company`() {
        println(">> Assert insert new company")
        every { companyRepository.save(companyX) } returns companyX

        mockMvc.perform(post("/companies")
                .content(companyX.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.cnpj").value(companyX.cnpj))
    }

    @Test
    fun `Assert delete one company`() {
        println(">> Assert delete one company")
        every { companyRepository.deleteById(eq(companyX.cnpj)) } just Runs

        mockMvc.perform(delete("/companies/${companyX.cnpj}")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk)
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}