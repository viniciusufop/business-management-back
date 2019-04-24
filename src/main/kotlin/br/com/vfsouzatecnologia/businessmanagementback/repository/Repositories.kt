package br.com.vfsouzatecnologia.businessmanagementback.repository

import br.com.vfsouzatecnologia.businessmanagementback.data.Company
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author vinicius
 * @since 24/04/19 13:29
 * @version : $<br/>
 *          : $
 *
 */
interface CompanyRepository : JpaRepository<Company, String>