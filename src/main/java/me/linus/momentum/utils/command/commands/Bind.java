package me.linus.momentum.utils.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.linus.momentum.Momentum;
import me.linus.momentum.utils.managers.MessageManager;
import me.linus.momentum.module.Module;
import me.linus.momentum.utils.command.Command;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    public Bind() {super("bind", new String[]{"bind"});}

    @Override
    public void onCommand(String[] args) {
        if (args.length > 2) {
            try {
                for (Module m: Momentum.moduleManager.getModules()) {
                    if (m.getName().equalsIgnoreCase(args[1])) {
                        try {
                            m.setKey(Keyboard.getKeyIndex(args[2].toUpperCase()));
                            MessageManager.sendMessagePrefix(ChatFormatting.AQUA + m.getName() + ChatFormatting.WHITE + " is now bound to " + ChatFormatting.RED + args[2].toUpperCase() + ChatFormatting.GRAY + " (" + ChatFormatting.WHITE + Keyboard.getKeyIndex(args[2].toUpperCase() + "") + ChatFormatting.GRAY + ")");
                        } catch (Exception e) {
                            MessageManager.sendMessagePrefix(ChatFormatting.RED + m.getName() + ChatFormatting.WHITE + " Something went wrong :(");

                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
