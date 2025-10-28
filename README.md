# Pumpkin's Custom Dungeonbreaker Texture Pack (PCDTP)

A small Gradle-based project for building Minecraft resource-pack ZIPs targeted at multiple pack formats (modern Firmament-style and legacy MCPatcher/Optifine). This repository packages per-target source folders together with shared `common` assets into distributable `.zip` files.

## Packaging

```bash
./gradlew build
```

- `./gradlew build` runs the project's `build` lifecycle which depends on the registered resource-pack tasks (group = "build resource pack"). That will create all zips defined in `buildPackTasks` and place them in `build/`.
- To run a single pack task directly, use its task name from `build.gradle.kts`, e.g.:

```bash
./gradlew buildModernPack
./gradlew buildLegacyPack
```

The produced ZIP archive base name is set in the Gradle script using `archiveBaseName.set(...)` and includes the root project name and `packVersion` from `gradle.properties`.
