import static org.springframework.cloud.contract.spec.Contract.*

make {
    request {
        method 'GET'
        url '/user'
    }
    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
                [
                        id              :   $(regex('[0-9]')),
                        name            :   "Anderson Nunes da Silva",
                        profession      :   "Analista de Sistemas",
                        email           :   "anderson.nunes@gmail.com",
                        age             :   28

                ],
                [
                        id              :   $(regex('[0-9]')),
                        name            :   "Francisco de Assis",
                        profession      :   "Vigia",
                        email           :   "francisco.assis@gmail.com",
                        age             :   53
                ]
        ])
    }
}