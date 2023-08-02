import axios from 'axios';

export default {

    getAllCategories() {
        return axios.get('/categories');
    },

    getAllProducts() {
        return axios.get('/products');
    },

    getProductById(productId) {
        return axios.get(`/products/${productId}`);
    }

}