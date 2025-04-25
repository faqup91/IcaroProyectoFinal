@Contact
  Feature: Completar formulario

    Background:
      Given el usuario se encuentra en Contacto de Contact


@ContactOk
Scenario Outline: El usuario completa los datos con valores correctos
    When el usuario ingres Full Name "<FullName>"
    And  el usuario indres Email address "<EmailAddress>"
    And  el usuario ingres Phone number  "<PhoneNumber>"
    And  el usuario ingres Message    "<Message>"
    And el usuario hace clic boton Submit
    Then el usuario visualiza el mensaje "<msjValidacion>"

    Examples:
      |FullName       | EmailAddress           | PhoneNumber    | Message         | msjValidacion                       |
      |Facundo        |facundo@gmail.com       | 3412558822     |hola soy facundo | El envio del formulario fue exitoso |