package br.com.vfsouzatecnologia.businessmanagementback.repository

import br.com.vfsouzatecnologia.businessmanagementback.data.Company
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

/**
 * @author vinicius
 * @since 24/04/19 13:32
 * @version : $<br/>
 *          : $
 *
 */
@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val companyRepository: CompanyRepository) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
        val newCompany = Company("70923128000102", "Empresa de teste tecnologia")
        companyRepository.save(newCompany)
    }

    @Test
    fun `insert new company`() {
        val newCompany = Company("70923128000102", "Empresa de teste tecnologia")
        companyRepository.save(newCompany)
    }

    @AfterAll
    fun teardown() {
        companyRepository.deleteAll()
        println(">> Tear down")
    }
}