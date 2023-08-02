import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import ProductService from '../services/ProductService.js'

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
    categoryFilter: 'All',
    categories: [],
    shoppingCart: []
  },
  getters: {
    categories(state) {
      return state.categories;
    },
    isLoggedIn(state) {
      return state.token;
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
    loadCategories(state) {

      ProductService.getAllCategories().then( response => {
        const arrayFromApi = response.data;
        arrayFromApi.unshift('All');
        state.commit('ADD_ALL_CATEGORIES', arrayFromApi);
      }).catch( error => console.error(error) );

    }
  },
  modules: {
  },
  strict: true
})
