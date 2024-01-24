# spyn-android

## About
Spyn for Android is a simple app I built for the Discogs API. It's intended to solve the following
issues:

 - Demonstrate my current best practices in a modularized and layered app, i.e. 
   - Layers are split by a Unit-testable protocol and as such are fully Fakeable
   - Unidirectional application flow (data flows to the UI, actions flow back)
   - Coroutines
   - MVVM architecture
   - Dependency Inverted (and may injected...)
   - UI is Compose
 - Act as a playground to test new concepts
   - Goal is to build this and then fully migrate to Kotlin Multiplatform
 - Prevent me from buying yet another copy of Trans Europa Express next time I walk into a record
   store as I cannot remember what I have in my collection...


## Getting Started

Should be as simple as opening and trusting the project, Gradle syncing, and then running

Unit tests are also available

### Test Coverage Report

Test Coverage is provided by [Kover](https://kotlin.github.io/kotlinx-kover/gradle-plugin/#kotlin-android-project)
via the Gradle Plugin

#### Coverage Verification
You can run a verification task (i.e. coverage is above 60%) at any time with 

`./gradlew koverVerifyDebug`

   Note: replace Debug with your build variant of choice

- [ ] Add Precommit hook for Kover 


#### Coverage Report
for a deeper dive into the report, run 

`./gradlew koverHtmlReportDebug`

   Note: Replace Debug with build variant of choice, and HTML with XML/Binary depending on CI 

- [ ] Add Precommit hook for Kover

### Lint (KtLint)

Linting is provided by [KTLint](https://pinterest.github.io/ktlint/latest/) via 
the [JLLeitschuh](https://github.com/jlleitschuh/ktlint-gradle) gradle Plugin

#### Tasks

Run `./gradlew ktlintCheck` to check all sources in project

Run `./gradlew ktlintFormat` to automatically fix all safe issues (note: May not be working 
correctly a this time)


- [ ] Add Test and (if needed) fix KTLintFormat
- [ ] Add Precommit hook for KTlint


## Contributing

I have no idea if anyone will want to contribute to this, but drop me a line if you're interested


## License
