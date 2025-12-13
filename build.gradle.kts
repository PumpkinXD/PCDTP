/**
 *
 * @author PumpkinXD
 * @description Gradle build configuration for packaging Minecraft resource packs.
 *              Modified from:
 *                 https://github.com/ILikePlayingGames/FancyWarpMenuResourcePacks/blob/c2b422d1fb7e4df4268815c8d1bf9b5f9de49629/build.gradle.kts
 *
 */


plugins {
    base
}


/**
 * taskName : FolderName : packName
 */
val buildPackTasks: List<Triple<String, String, String>> = listOf(
Triple("buildModernPack", "1.21.8","${rootProject.name} ${project.properties["packVersion"]} for 1.21.2~11"),
Triple("buildLegacyPack", "1.8.9","${rootProject.name} ${project.properties["packVersion"]} for 1.8.x"),
)

tasks.build {
    dependsOn(tasks.matching { it.group.equals("build resource pack") })
}

for (taskEntry in buildPackTasks) {
    tasks.register<Zip>(taskEntry.first) {
        group = "build resource pack"
        archiveBaseName.set(taskEntry.third)
        destinationDirectory.set(layout.buildDirectory)
        from(layout.projectDirectory.dir("src/${taskEntry.second}"))
        from(layout.projectDirectory.dir("src/common"))
        // filesMatching("pack.mcmeta") {
        //     expand("Version" to project.properties["packVersion"])
        // }
    }
}

