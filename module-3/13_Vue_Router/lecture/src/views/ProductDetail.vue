<template>
<div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
        <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'add-review', params: {id: product.id} }">Add Review</router-link>
    </div>
    <div class="well-display">
        <AverageSummaryVue/>
        <StarSummaryVue rating="1" />
        <StarSummaryVue rating="2" />
        <StarSummaryVue rating="3" />
        <StarSummaryVue rating="4" />
        <StarSummaryVue rating="5" />
    </div>
    <ReviewListVue />
</div>
</template>

<script>
import AverageSummaryVue from '../components/AverageSummary.vue';
import ReviewListVue from '../components/ReviewList.vue';
import StarSummaryVue from '../components/StarSummary.vue';
export default {
  name: "product-detail",
  components: {
      AverageSummaryVue,
      ReviewListVue,
      StarSummaryVue,
  },
  data() {
    return {};
  },
  computed: {
      product() {
          return this.$store.getters.product;
      }
  },
  created() {
      const productId = this.$route.params.id;
      this.$store.commit('SET_ACTIVE_PRODUCT',productId)
  },
};
</script>

<style>
</style>