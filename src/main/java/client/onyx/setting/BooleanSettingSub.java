package client.onyx.setting;

import java.util.List;

public class BooleanSettingSub extends BooleanSetting {
   private final List<String> list2;

   public List<String> getList5() {
      return this.list2;
   }

   protected BooleanSettingSub(String var1, String... var2) {
      super(var1);
      this.list2 = List.of(var2);
   }
}
