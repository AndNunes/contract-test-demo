import static org.springframework.cloud.contract.spec.Contract.*

make {
    request {
        method  'POST'
        url '/user'
        body([
                "name"            :   "Anderson Nunes da Silva",
                "profession"      :   "Analista de Sistemas",
                "email"           :   "anderson.nunes@gmail.com",
                "age"             :   28
        ])
    }
    response {
        headers {
            contentType applicationJson()
        }
        body([
                "id"            :   Utils.anyId(),
                "name"          :   Utils.anyNameNoEmpty(),
                "profession"    :   Utils.anyProfession(),
                "email"         :   Utils.anyEMail(),
                "age"           :   Utils.anyAge()
        ])
        status  202
    }
}