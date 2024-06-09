## Описание проекта

Этот проект демонстрирует использование JUnit 5 для тестирования класса `Calculator` с различными подходами и аннотациями, включая параметризованные тесты, использование Mockito для создания мок-объектов и расширение тестов с помощью `@ExtendWith`.

### Структура проекта

Проект включает следующие основные компоненты:

1. **Класс `Calculator`**:
    - Расположен в пакете `Junit5_Gradle_Extensions`.
    - Предоставляет методы для сложения (`addition`), вычитания (`subtract`) и деления (`division`) двух чисел.

2. **Тесты**:
    - Расположены в пакете `tests`.
    - Тесты организованы в нескольких классах, демонстрирующих различные возможности JUnit 5 и Mockito.

### Тестовые классы

#### `CalculatorTests`

Этот класс содержит базовые юнит-тесты для методов `Calculator`, а также примеры использования `@BeforeEach`, `@DisplayName`, `@Tag`, `@Disabled`, `@RepeatedTest` и `@Nested`.

#### `CalculatorWithLoggingTests`

Этот класс демонстрирует использование расширений JUnit 5 с помощью `@ExtendWith` и собственного расширения `LoggingExtension`.

#### `CalculatorParameterizedTests`

Этот класс демонстрирует использование параметризованных тестов в JUnit 5 с аннотациями `@CsvSource`, `@CsvFileSource` и `@MethodSource`.

### Расширение `LoggingExtension`

Расширение для логирования, которое выводит сообщение до и после выполнения каждого теста.

### Сборка и запуск тестов

Проект использует Gradle для управления зависимостями и выполнения тестов. Основные задачи включают:

- **unitTest**: Выполняет все тесты с тегом `unit`.
- **parametrizedTest**: Выполняет все тесты с тегом `parametrized`.

### Пример настройки зависимостей и задач в `build.gradle`

```gradle
plugins {
    id 'java-library'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(
            "org.junit.jupiter:junit-jupiter:5.9.3",
            "org.mockito:mockito-all:1.10.19"
    )
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

test {
    useJUnitPlatform()
}

task unitTest(type: Test) {
    useJUnitPlatform {
        includeTags 'unit'
    }
    testLogging {
        events "passed", "skipped", "failed"
    }
}

task parametrizedTest(type: Test) {
    useJUnitPlatform {
        includeTags 'parametrized'
    }
    testLogging {
        events "passed", "skipped", "failed"
    }
}
