<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input
              type="checkbox"
              id="selectAll"
              v-on:change="selectAll($event)"
              v-bind:checked="allSelected"
            />
          </td>
          <td>
            <input
              type="text"
              id="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input
              type="checkbox"
              v-bind:id="user.id"
              v-bind:value="user.id"
              v-bind:checked="selectedUserIDs.includes(user.id)"
              v-on:change="selectIndividual($event, user)"
            />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button
              class="btnActivateDeactivate"
              v-on:click="changeStatus(user.id)"
            >
              {{ user.status === "Inactive" ? "Activate" : "Deactivate" }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button
        v-bind:disabled="selectedUserIDs.length === 0"
        v-on:click="changeAllStatusActive()"
      >
        Activate Users
      </button>
      <button
        v-bind:disabled="selectedUserIDs.length === 0"
        v-on:click="changeAllStatusInactive()"
      >
        Deactivate Users
      </button>
      <button v-bind:disabled="selectedUserIDs.length === 0"
      v-on:click="deleteUser()">
        Delete Users
      </button>
    </div>

    <button id="show-form-button" href="#" v-on:click="showForm = !showForm">
      Add New User
    </button>

    <form id="frmAddNewUser" v-on:submit.prevent="addNewUser" v-show="showForm">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" v-model.trim="newUser.firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" v-model.trim="newUser.lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" name="username" v-model.trim="newUser.username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input
          type="text"
          name="emailAddress"
          v-model.trim="newUser.emailAddress"
        />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "user-list",
  data() {
    return {
      selectedUserIDs: [],
      showForm: false,
      newUserEntry: {},
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive",
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive",
        },
      ],
    };
  },
  methods: {
    addNewUser() {
      let id = this.getNextUserId();
      this.newUser.id = id;
      this.users.unshift(this.newUser);
      this.resetForm();
    },
    resetForm() {
      this.newUser = {};
      this.showForm = false;
    },
    getNextUserId() {
      return this.nextUserId++;
    },
    selectAll(event) {
      if (event.target.checked) {
        this.selectedUserIDs = [];
        this.users.forEach((user) => this.selectedUserIDs.push(user.id));
      } else {
        this.selectedUserIDs = [];
      }
    },
    selectIndividual(event, user) {
      if (event.target.checked) {
        this.selectedUserIDs.push(user.id);
      } else {
        this.selectedUserIDs.pop(user.id);
      }
    },
    changeStatus(userId) {
      let user = this.users.find((id) => id.id === userId);
      if (user.status === "Active") {
        user.status = "Inactive";
      } else {
        user.status = "Active";
      }
    },
    changeAllStatusActive() {
     this.selectedUserIDs.forEach(id => {
      let foundUser = this.users.find(user => user.id === id);
      foundUser.status = "Active"; 
      });
    },
    changeAllStatusInactive(){
     this.selectedUserIDs.forEach(id => {
      let foundUser = this.users.find(user => user.id === id);
      foundUser.status = "Inactive"; 
      });
    },
    deleteUser() {
     this.selectedUserIDs.forEach(id => {
      let foundUser = this.users.find(user => user.id === id);
      this.users.pop(foundUser);
    });
    }
  },

  computed: {
    allSelected() {
      if (this.selectedUserIDs.length === this.users.length) {
        return true;
      }
      return false;
    },
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter(
          (user) => user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
