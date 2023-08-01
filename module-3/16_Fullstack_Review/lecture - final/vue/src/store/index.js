import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
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
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
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
