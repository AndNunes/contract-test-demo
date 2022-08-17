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
                        id              :   Utils.anyId(),
                        name            :   Utils.anyNameNoEmpty(),
                        profession      :   Utils.anyProfession(),
                        email           :   Utils.anyEMail(),
                        age             :   Utils.anyAge()

                ],
                [
                        id              :   Utils.anyId(),
                        name            :   Utils.anyNameNoEmpty(),
                        profession      :   Utils.anyProfession(),
                        email           :   Utils.anyEMail(),
                        age             :   Utils.anyAge()
                ]
        ])
    }
}