<template>
  <div>
      <BestSellerListVue />
      <NewReleasesListVue />
  </div>
</template>

<script>
import BestSellerListVue from '../components/BestSellerList.vue'
import NewReleasesListVue from '../components/NewReleasesList.vue'
export default {
    components: {
        BestSellerListVue,
        NewReleasesListVue
    }
}
</script>

<style>

</style>