<template>
  <div class="productsView">
      <CategoryFilterVue />
      <ProductListVue />
  </div>
</template>

<script>
import CategoryFilterVue from '../components/CategoryFilter.vue'
import ProductListVue from '../components/ProductList.vue'
export default {
    components: {
        ProductListVue,
        CategoryFilterVue
    }
}
</script>

<style>

</style>