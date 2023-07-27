<template>
  <div class="products">
      <h1>Products</h1>
      <ProductsListVue />
  </div>
</template>

<script>
import ProductsListVue from '../components/ProductsList.vue'
export default {
    components: {
        ProductsListVue
    }
}
</script>

<style>

</style>