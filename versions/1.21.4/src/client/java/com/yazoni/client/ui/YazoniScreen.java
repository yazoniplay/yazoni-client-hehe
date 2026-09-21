package com.yazoni.client.ui;
import com.yazoni.client.YazoniClient;
import com.yazoni.client.module.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
public final class YazoniScreen extends Screen{
 private Category selected=Category.PERFORMANCE;
 public YazoniScreen(){super(Component.literal("Yazoni Client"));}
 @Override public void render(GuiGraphics g,int mx,int my,float d){super.render(g,mx,my,d);g.fill(0,0,width,height,0xF006080B);int l=Math.max(12,width/2-360),t=Math.max(12,height/2-220);g.fill(l,t,l+720,t+440,0xF010141A);g.fill(l,t,l+4,t+440,0xFFFF6900);g.drawString(font,"YAZONI CLIENT",l+20,t+18,0xFFFFFFFF,true);int sy=t+65;for(Category c:Category.values()){boolean a=c==selected,h=mx>=l+12&&mx<=l+155&&my>=sy-4&&my<=sy+18;g.fill(l+12,sy-4,l+155,sy+18,a?0xFFFF6900:h?0xFF202831:0xFF171C22);g.drawString(font,c.displayName(),l+22,sy+2,a?0xFF101010:0xFFD8DCE1);sy+=28;}int x=l+175,y=t+60,row=0;for(Module m:YazoniClient.MODULES.category(selected)){int yy=y+row*36;if(yy>t+405)break;boolean h=mx>=x&&mx<=l+700&&my>=yy&&my<=yy+30;g.fill(x,yy,l+700,yy+30,h?0xFF202831:0xFF171C22);g.drawString(font,m.name(),x+10,yy+6,0xFFFFFFFF);g.drawString(font,m.enabled()?"ON":"OFF",l+645,yy+6,m.enabled()?0xFF55DD88:0xFF68727E,true);row++;}}
 @Override public boolean mouseClicked(double mx,double my,int button){if(button!=0)return super.mouseClicked(mx,my,button);int l=Math.max(12,width/2-360),t=Math.max(12,height/2-220),sy=t+65;for(Category c:Category.values()){if(mx>=l+12&&mx<=l+155&&my>=sy-4&&my<=sy+18){selected=c;return true;}sy+=28;}int x=l+175,y=t+60,row=0;for(Module m:YazoniClient.MODULES.category(selected)){int yy=y+row*36;if(yy>t+405)break;if(mx>=x&&mx<=l+700&&my>=yy&&my<=yy+30){if(mx>=l+620)m.toggle();else if(!m.settings().isEmpty())minecraft.setScreen(new YazoniSettingsScreen(m));return true;}row++;}return super.mouseClicked(mx,my,button);}
}
