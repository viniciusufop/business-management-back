package br.com.vfsouzatecnologia.businessmanagementback.data

import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author vinicius
 * @since 24/04/19 13:06
 * @version : $<br/>
 *          : $
 *
 */
@Entity
class Company(
        @Id var cnpj: String,
        var name: String
) {
    override fun toString(): String {
        return """
             {
               "cnpj": "$cnpj",
               "name": "$name"
             }
        """
    }
}