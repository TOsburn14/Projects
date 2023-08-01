import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    products: [],
    categoryFilter: 'All',
    categories: [],
    shoppingCart: []
  },
  getters: {
    products(state) {
      return state.products;
    },
    categories(state) {
      return state.categories;
    },
    getProductById: (state) => (productId) => {
      return state.products.find( p => p.id == productId);
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
    },
    ADD_PRODUCT_TO_SHOPPING_CART(state, productId) {
      const product = state.products.find( p => p.id == productId);
      state.shoppingCart.push(product);
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
