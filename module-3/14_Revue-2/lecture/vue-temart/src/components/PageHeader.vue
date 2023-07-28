<template>
  <header>
    <img src="../assets/temart-logo.png" alt="" />
    <div>
      <ShoppingCartCountVue />
    </div>
  </header>
</template>

<script>
import ShoppingCartCountVue from "./ShoppingCartCount.vue";
export default {
  name: "page-header",
  components: {
    ShoppingCartCountVue,
  },
};
</script>

<style>
header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 100px;
  border-bottom: 2px darkblue solid;
}
img {
  width: 150px;
}
</style>