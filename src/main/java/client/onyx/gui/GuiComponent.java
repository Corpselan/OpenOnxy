package client.onyx.gui;

import client.onyx.MinecraftAccess;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GuiComponent implements MinecraftAccess {
   protected boolean bool;
   protected final List<GuiComponent> list = new ArrayList<>();
   protected boolean bool2 = true;
   protected float float_;
   protected float float_2;
   protected float float_3;
   protected boolean bool3;
   protected float float_4;

   public boolean isFloat19(float var1, float var2, int var3) {
      boolean var7 = false;

      Iterator var5;
      for (Iterator var10000 = var5 = this.list.iterator(); var10000.hasNext(); var10000 = var5) {
         GuiComponent var6 = (GuiComponent)var5.next();
         var7 |= var6.isFloat19(var1, var2, var3);
      }

      return var7;
   }

   public boolean isFloat16(float var1, float var2, double var3) {
      Iterator var6 = this.list.iterator();

      while (var6.hasNext()) {
         if (((GuiComponent)var6.next()).isFloat16(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   public float getFloat119() {
      return this.float_4;
   }

   public float getFloat115() {
      return this.float_;
   }

   public boolean isEnabled146() {
      return this.bool;
   }

   public boolean isEnabled148() {
      return this.bool2;
   }

   public float getFloat117(float var1) {
      return this.float_2;
   }

   public boolean isKeyScancodeRecord3(KeyScancodeRecord var1) {
      Iterator var3 = this.list.iterator();

      while (var3.hasNext()) {
         if (((GuiComponent)var3.next()).isKeyScancodeRecord3(var1)) {
            return true;
         }
      }

      return false;
   }

   public void handleCls28(Cls2 var1) {
      this.bool = this.bool2 && this.isFloat15(var1.float_3, var1.float_2);

      Iterator var3;
      for (Iterator var10000 = var3 = this.list.iterator(); var10000.hasNext(); var10000 = var3) {
         ((GuiComponent)var3.next()).handleCls28(var1);
      }
   }

   public void handleFloat80(float var1, float var2, float var3, float var4) {
      this.float_3 = var1;
      this.float_ = var2;
      this.float_4 = var3;
      this.float_2 = var4;
      this.run185();
   }

   public boolean isEnabled147() {
      return this.bool3;
   }

   public List<GuiComponent> getList26() {
      return this.list;
   }

   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      Iterator var3 = this.list.iterator();

      while (var3.hasNext()) {
         if (((GuiComponent)var3.next()).isCodepointModifiersRecord(var1)) {
            return true;
         }
      }

      return false;
   }

   public float getFloat118() {
      return this.float_3;
   }

   public void handleCls27(Cls2 var1) {
      Iterator var3;
      for (Iterator var10000 = var3 = this.list.iterator(); var10000.hasNext(); var10000 = var3) {
         ((GuiComponent)var3.next()).handleCls27(var1);
      }
   }

   public boolean isFloat18(float var1, float var2, int var3, float var4, float var5) {
      Iterator var7 = this.list.iterator();

      while (var7.hasNext()) {
         if (((GuiComponent)var7.next()).isFloat18(var1, var2, var3, var4, var5)) {
            return true;
         }
      }

      return false;
   }

   public float getFloat116() {
      return this.float_2;
   }

   protected void run185() {
   }

   public boolean isFloat17(float var1, float var2, int var3) {
      Iterator var6 = this.list.iterator();

      while (var6.hasNext()) {
         GuiComponent var5;
         if ((var5 = (GuiComponent)var6.next()).bool2 && var5.isFloat17(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   public boolean isFloat15(float var1, float var2) {
      if (var1 >= this.float_3) {
         float var4 = this.float_3 + this.float_4;
         if (var1 < var4 && var2 >= this.float_) {
            float var7 = this.float_ + this.float_2;
            if (var2 < var7) {
               return true;
            }
         }
      }

      return false;
   }

   public void handleBool23(boolean var1) {
      this.bool2 = var1;
   }
}
