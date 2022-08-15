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
        status  202
        headers {
            contentType applicationJson()
        }
        body([
                "id"            :   $(regex('[0-9]')),
                "name"          :   "Anderson Nunes da Silva",
                "profession"    :   "Analista de Sistemas",
                "email"         :   "anderson.nunes@gmail.com",
                "age"           :   28
        ])
    }
}