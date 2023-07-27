<template>
  <div id="app" class="main">
      <h1>{{ product.name }}</h1>
      <p class="description">{{ product.description }}</p>
      <div class="actions">
          <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{
                name: 'add-review',
                params: {
                    id: product.id
                }
              }">Add Review</router-link>
      </div>
      <div class="well-display">
          <AverageSummary />
          <StarSummary rating="1" />
          <StarSummary rating="2" />
          <StarSummary rating="3" />
          <StarSummary rating="4" />
          <StarSummary rating="5" />
      </div>
      <ReviewList />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'

export default { 
    name: 'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    data() {
        return {}
    },
    computed: {
        product() {
            return this.$store.getters.product;
        }
    },
    created() {
        // $route references the URL.  Here we are getting a parameter
        // named id from the route.  The parameter id was defined in the 
        // router/index.js
        const productId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', productId)
    }
}
</script>

<style>

</style>