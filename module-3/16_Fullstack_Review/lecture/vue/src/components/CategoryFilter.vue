<template>
    <div class="filter">
        <select v-model="categoryFilter" @change="updateCategoryFilter()">
          <option v-for="cat in $store.getters.categories" 
            :key="cat" 
            :value="cat">{{cat}}</option>
        </select>
      </div>
</template>

<script>
export default {
    name: 'category-filter',
    data() {
        return {
            categoryFilter: this.$store.state.categoryFilter
        }
    },
    methods: {
        updateCategoryFilter() {
            this.$store.commit('UPDATE_CATEGORY_FILTER', this.categoryFilter);
        }
    },
    created() {
        this.$store.dispatch('loadCategories');
    }
}
</script>

<style>

</style>