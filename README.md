# ⚡ Yazoni Client

A custom Minecraft Java Edition client focused on **performance, PvP, HUD customization, visuals, and a clean modern interface**.

## Supported foundations

| Minecraft | Foundation | Java | Loom family |
|---|---|---:|---|
| **1.20.6** | ✅ | 21 | Remap |
| **1.21.1** | ✅ | 21 | Remap |
| **1.21.4** | ✅ | 21 | Remap |
| **1.21.11** | ✅ | 21 | Remap |
| **26.2** | ✅ | 25 | Unobfuscated |
| **26.3** | ✅ | 25 | Unobfuscated |

The older releases live under `versions/<minecraft-version>/`, while the current 26.3 project remains at the repository root.

Fabric's current documentation confirms that **1.21.11 and older use `fabric-loom-remap`**, while **26.1+ use `fabric-loom`** because Minecraft moved to unobfuscated code. citeturn1search3turn1search5

## Roadmap

### Foundation
- [x] Multi-version foundation
- [x] Fabric client entrypoints
- [x] Version-specific Gradle projects
- [x] 1.20.6 foundation
- [x] 1.21.1 foundation
- [x] 1.21.4 foundation
- [x] 1.21.11 foundation
- [x] 26.2 foundation
- [x] 26.3 foundation
- [ ] Shared core architecture
- [ ] Config system
- [ ] Module system
- [ ] Cross-version API layer

### Performance
- [ ] FPS optimization
- [ ] Render optimization
- [ ] Entity optimization
- [ ] Particle optimization
- [ ] Memory optimization
- [ ] Performance presets
- [ ] Frametime monitor
- [ ] Low-end mode

### PvP
- [ ] CPS counter
- [ ] FPS / ping HUD
- [ ] Keystrokes
- [ ] ToggleSprint
- [ ] Zoom
- [ ] Armor HUD
- [ ] Cooldown HUD
- [ ] Custom crosshair
- [ ] Hit effects
- [ ] Combat information

### UI
- [ ] Custom main menu
- [ ] Settings screen
- [ ] HUD editor
- [ ] Themes
- [ ] Animations
- [ ] Profiles

### Future
- [ ] Cosmetics
- [ ] Cloud config sync
- [ ] Client launcher
- [ ] Automatic updates
- [ ] More performance systems

## Development

### Current root build
- Minecraft **26.3**
- Fabric Loader **0.19.5**
- Fabric API **0.160.6+26.3**
- Java **25**

### Version builds
Each version has its own isolated Gradle project so Minecraft API/mapping differences stay contained instead of contaminating the shared client architecture.

Fabric's official release notes document the 1.21.4, 26.2, and 26.3 toolchains used as the basis for these foundations. citeturn0search1turn0search5turn0search4
