package example;

import com.github.koxx12dev.fuckyou.ImGuiGL3;
import com.github.koxx12dev.fuckyou.ImGuiLwjgl2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.lang.reflect.Executable;
import imgui.ImGui;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImGuiRenderer {
    private static ImGuiRenderer instance;
    private final List<ImGuiCall> draws = new ArrayList<>();
    private final ImGuiGL3 imGuiGl = new ImGuiGL3();
    private final ImGuiLwjgl2 imGuiLwjgl = new ImGuiLwjgl2();

    private ImGuiRenderer() {}

    public static ImGuiRenderer getInstance() {
        if (instance == null) {
            instance = new ImGuiRenderer();
        }
        return instance;
    }

    public void init() {
        ImGui.createContext();
        imGuiLwjgl.init();
        imGuiGl.init();
        ImGui.init();
    }

    public void draw(ImGuiCall call) {
        draws.add(call);
    }

    public void render(Framebuffer fb, float delta) {
        //startup fix
        if (delta <= 0f) delta = 0.1f;
        imGuiLwjgl.newFrame(fb.framebufferWidth, fb.framebufferHeight, delta);
        ImGui.newFrame();

        draws.forEach(ImGuiCall::execute);
        draws.clear();

        ImGui.render();
        imGuiGl.renderDrawData(Objects.requireNonNull(ImGui.getDrawData()));
    }

    //register this somewhere
    public void handleScroll(float offset) {
        imGuiLwjgl.scrollCallback(offset / 120f);
    }

    //register this somewhere
    public void handleChar(int c) {
        imGuiLwjgl.charCallback(c);
    }

}
