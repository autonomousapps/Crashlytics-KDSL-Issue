# Crashlytics-KDSL-Issue
Reproducer for issue with Crashlytics and Kotlin DSL
The issue was originally described [here](https://stackoverflow.com/questions/53233826/android-and-the-fabric-crashlytics-plugin-always-generates-a-uuid-gradle-kotl), along with a workaround.

To verify that this works as expected with the Groovy DSL, checkout commit with ID **c3d3c5b**, run `./gradlew assembleDebug && ./gradlew assembleDebug`, and observe the output:
> 27 actionable tasks: 27 up-to-date

which indicates every task was up to date and none had to re-run.

To verify the issue with the Kotlin DSL, checkout **master** (or commit ID **00a532c**) and do the same thing. Observe the output
> 27 actionable tasks: 4 executed, 23 up-to-date

which indicates 4 tasks were re-run. You may furthermore navigate to the [build scan](https://scans.gradle.com/s/rbjvtykf2gmks/timeline?task=mvjiy2pq57wvg) and observe that the `:app:fabricGenerateResourcesDebug` task re-ran.
