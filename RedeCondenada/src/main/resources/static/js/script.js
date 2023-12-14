const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});


// Função para redirecionar para pagina de postagens ao clicar no botão
function redirectToFeed() {
    window.location.href = 'posts';
}

function redirectToPost() {
    window.location.href = 'newpost';
}
function logout() {
    window.location.href = 'exit';
}

function search() {
    window.location.href = 'userposts';
}

