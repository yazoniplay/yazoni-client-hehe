package com.yazoni.client.module;
import java.util.*;
public final class ModuleManager{private final List<Module> modules=new ArrayList<>();
public void register(Module m){if(modules.stream().noneMatch(x->x.id().equals(m.id())))modules.add(m);}
public Module get(String id){return modules.stream().filter(x->x.id().equals(id)).findFirst().orElse(null);}
public List<Module> search(String q){String s=q==null?"":q.trim().toLowerCase();return modules.stream().filter(m->s.isEmpty()||m.name().toLowerCase().contains(s)||m.id().toLowerCase().contains(s)||m.description().toLowerCase().contains(s)).sorted(Comparator.comparing(Module::name)).toList();}
public Collection<Module> all(){return List.copyOf(modules);} public List<Module> category(Category c){return modules.stream().filter(m->m.category()==c).sorted(Comparator.comparing(Module::name)).toList();}
public void tick(){modules.stream().filter(Module::enabled).forEach(Module::onTick);}}
