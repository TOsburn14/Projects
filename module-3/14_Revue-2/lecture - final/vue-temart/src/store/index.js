import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    products: [],
    categoryFilter: 'All',
    categories: []
  },
  getters: {
    products(state) {
      return state.products;
    },
    categories(state) {
      return state.categories;
    }
  },
  mutations: {
    ADD_ALL_PRODUCTS(state, productsArray) {
      state.products = productsArray;
    },
    UPDATE_CATEGORY_FILTER(state, newFilter) {
      state.categoryFilter = newFilter;
    },
    ADD_ALL_CATEGORIES(state, categoryArray) {
      state.categories = categoryArray
    }
  },
  actions: {
    loadProducts(state) {
      fetch('products.json').then( response => {
        return response.json();
      }).then( data => {
        state.commit('ADD_ALL_PRODUCTS', data);
      });
    },
    loadCategories(state) {
      // This array will be populated by an API call
      const arrayFromApi = ['Home', 'Apparel', 'Garden', 'Jewelry'];
      arrayFromApi.unshift('All');
      state.commit('ADD_ALL_CATEGORIES', arrayFromApi);
    }
  },
  modules: {
  },
  strict: true
})
