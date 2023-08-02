<template>
  <header>
      <router-link :to="{ name: 'products' }">
        <img src="../assets/temart-logo.png" alt="">
      </router-link>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'products' }" v-if="$store.getters.isLoggedIn">Products</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.getters.isLoggedIn">Logout</router-link>
    </div>
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