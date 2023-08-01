<template>
  <div class="productsView">
      <CategoryFilter />
      <ProductList />
  </div>
</template>

<script>
import ProductList from '@/components/ProductList.vue'
import CategoryFilter from '@/components/CategoryFilter.vue'

export default {
    components: {
        ProductList,
        CategoryFilter
    }
}
</script>

<style>

</style>