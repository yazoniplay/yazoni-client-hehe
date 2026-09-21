package com.yazoni.client.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void register(Module module) {
        if (modules.stream().noneMatch(existing -> existing.id().equals(module.id()))) {
            modules.add(module);
        }
    }

    public Module get(String id) {
        return modules.stream().filter(module -> module.id().equals(id)).findFirst().orElse(null);
    }

    public List<Module> search(String query) {
        String q = query == null ? "" : query.trim().toLowerCase();
        return modules.stream()
                .filter(module -> q.isEmpty()
                        || module.name().toLowerCase().contains(q)
                        || module.id().toLowerCase().contains(q)
                        || module.description().toLowerCase().contains(q))
                .sorted(Comparator.comparing(Module::name))
                .toList();
    }

    public Collection<Module> all() { return List.copyOf(modules); }

    public List<Module> category(Category category) {
        return modules.stream()
                .filter(module -> module.category() == category)
                .sorted(Comparator.comparing(Module::name))
                .toList();
    }

    public void tick() {
        modules.stream().filter(Module::enabled).forEach(Module::onTick);
    }
}
