package me.linus.momentum.module.modules.player;

import me.linus.momentum.Momentum;
import me.linus.momentum.module.Category;
import me.linus.momentum.utils.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import me.linus.momentum.api.events.mixin.PacketEvent;
import me.linus.momentum.module.Module;
import net.minecraft.network.play.client.CPacketCloseWindow;

/*
 * jakemodule 2020
 */

public class ExtraSlots extends Module {
  public ExtraSlots() {
    super("ExtraSlots", Category.Player);
  }

  Setting hidden;

  @Override
  public void setup(){
    rSetting(hidden = new Setting("Hidden", this, false, "hide"));
  }

  @Override
  public void onEnable() {
    Momentum.EVENT_BUS.subscribe(this);
  }

  @Override
  public void onDisable() {
    Momentum.EVENT_BUS.unsubscribe(this);
  }

  @EventHandler
  private Listener<PacketEvent.Send> listener = new Listener<>(event -> {
    if(event.getPacket() instanceof CPacketCloseWindow){
      event.cancel();
    }

  });
}