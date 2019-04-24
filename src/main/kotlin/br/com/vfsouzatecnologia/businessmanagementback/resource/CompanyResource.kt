package br.com.vfsouzatecnologia.businessmanagementback.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author vinicius
 * @since 24/04/19 12:51
 * @version : $<br/>
 *          : $
 *
 */
@RestController
@RequestMapping("/company")
class CompanyResource {

    @GetMapping
    fun getAll(): String {
        return ""
    }
}