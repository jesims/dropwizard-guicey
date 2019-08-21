package ru.vyarus.dropwizard.guice.module.context.debug.report.guice.model;

import com.google.inject.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Guice module descriptor.
 *
 * @author Vyacheslav Rusakov
 * @since 13.08.2019
 */
public class ModuleDeclaration {

    private Class type;
    private String parent;
    private final List<ModuleDeclaration> children = new ArrayList<>();
    private final List<BindingDeclaration> declarations = new ArrayList<>();
    private final List<String> markers = new ArrayList<>();
    private boolean privateModule;

    public Class getType() {
        return type;
    }

    public void setType(final Class type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(final String parent) {
        this.parent = parent;
    }

    public List<ModuleDeclaration> getChildren() {
        return children;
    }

    public List<BindingDeclaration> getDeclarations() {
        return declarations;
    }

    public List<String> getMarkers() {
        return markers;
    }

    public boolean isJITBindings() {
        return Module.class.equals(type);
    }

    public boolean isPrivateModule() {
        return privateModule;
    }

    public void setPrivateModule(final boolean privateModule) {
        this.privateModule = privateModule;
    }

    /**
     * @return true for synthetic module, collecting JIT bindings.
     */
    public boolean isJitModule() {
        return getType().equals(Module.class);
    }

    @Override
    public String toString() {
        return type.getSimpleName();
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof ModuleDeclaration && Objects.equals(type, ((ModuleDeclaration) obj).getType());
    }
}
