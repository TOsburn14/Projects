<template>
  <header>
      <router-link :to="{ name: 'products' }">
        <img src="../assets/temart-logo.png" alt="">
      </router-link>
      
      <div>
          <ShoppingCartCount />
      </div>
  </header>
</template>

<script>
import ShoppingCartCount from '@/components/ShoppingCartCount.vue'
export default {
    name: 'page-header',
    components: {
      ShoppingCartCount
    }
}
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