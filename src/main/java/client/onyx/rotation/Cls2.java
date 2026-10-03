package client.onyx.rotation;

import client.onyx.MinecraftAccess;
import client.onyx.rotation.data.YawPitchRecord;
import client.onyx.rotation.mode.OffStrictEnum;
import client.onyx.rotation.mode.api.Iface;
import client.onyx.util.Cls5;
import client.onyx.util.Util2;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;

public class Cls2 implements MinecraftAccess {
   private final YawPitchRecord yawPitchRecord;
   private final int int_;
   private final float float_;
   private final List<Iface> list;
   private Entity entity;
   private final boolean bool;
   private final OffStrictEnum offStrictEnum;
   private final Cls5 cls5;

   private YawPitchRecord getYawPitchRecord7(YawPitchRecord var1, YawPitchRecord var2) {
      if (this.list.isEmpty()) {
         return var2;
      } else {
         var2 = var2;

         Iterator var3;
         for (Iterator var10000 = var3 = this.list.iterator(); var10000.hasNext(); var10000 = var3) {
            var2 = ((Iface)var3.next()).getYawPitchRecord9(this, var1, var2);
         }

         return var2;
      }
   }

   public YawPitchRecord getYawPitchRecord6() {
      return this.yawPitchRecord;
   }

   public void handleEntity(Entity var1) {
      this.entity = var1;
   }

   public Cls5 getCls52() {
      return this.cls5;
   }

   public Entity getEntity() {
      return this.entity;
   }

   public int getInt21() {
      return this.int_;
   }

   public OffStrictEnum getOffStrictEnum2() {
      return this.offStrictEnum;
   }

   public Cls2(YawPitchRecord var1, Entity var2, List<Iface> var3, int var4, float var5, boolean var6, OffStrictEnum var7, Cls5 var8) {
      this.yawPitchRecord = var1;
      this.entity = var2;
      this.list = var3;
      this.int_ = var4;
      this.float_ = var5;
      this.bool = var6;
      this.offStrictEnum = var7;
      this.cls5 = var8;
   }

   public List<Iface> getList10() {
      return this.list;
   }

   public YawPitchRecord getYawPitchRecord8(YawPitchRecord var1, boolean var2) {
      if (var2) {
         this.entity = null;
         return this.getYawPitchRecord7(var1, Util2.getYawPitchRecordForEntity(MINECRAFT.thePlayer));
      } else {
         return this.getYawPitchRecord7(var1, this.yawPitchRecord);
      }
   }

   public boolean isEnabled53() {
      return this.bool;
   }

   public float getFloat27() {
      return this.float_;
   }
}
