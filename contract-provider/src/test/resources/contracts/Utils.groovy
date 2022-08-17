import org.springframework.cloud.contract.spec.internal.ClientDslProperty

import java.util.regex.Pattern

static ClientDslProperty anyNameNoEmpty() {
    return new ClientDslProperty(randomName(), Pattern.compile("[\\S\\s]+"))
}

static ClientDslProperty anyProfession() {
    return new ClientDslProperty(randomProfession(), Pattern.compile("[\\S\\s]+"))
}

static ClientDslProperty anyEMail() {
    return new ClientDslProperty(randomEmail(), Pattern.compile("[\\s\\s]+"))
}

static ClientDslProperty anyAge() {
    return new ClientDslProperty(randomAge(), Pattern.compile("([1-9]\\d*)"))
}

static ClientDslProperty anyId() {
    return new ClientDslProperty(randomId(), Pattern.compile("([1-9]\\d*)"))
}

private static String randomProfession() {
    List<String> profession = Arrays.asList("Programador", "Musico", "Medico", "Professor")
    Collections.shuffle(profession)
    return profession.get(0)
}

private static String randomName() {
    List<String> name = Arrays.asList("Anderson", "Joelma", "Chimbinha")
    Collections.shuffle(name);
    List<String> surname = Arrays.asList("Nunes", "Cantora", "Guitarrista")
    Collections.shuffle(surname)
    return new StringJoiner(" ").add(name.get(0)).add(surname.get(0))
}

private static String randomEmail() {
    List<String> firstName = Arrays.asList("anderson", "joelma", "chimbinha")
    Collections.shuffle(firstName)
    List<String> lastName = Arrays.asList("nunes", "cantora", "guitarrista")
    Collections.shuffle(lastName)

    String firstPartOfEmail = new StringJoiner(".").add(firstName.get(0)).add(lastName.get(0))

    return firstPartOfEmail + "@gmail.com"
}

private static int randomAge() {
    return new Random().nextInt((60 - 10) + 1) + 10
}

private static int randomId() {
    return new Random().nextInt(100)
}