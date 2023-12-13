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
function redirectToAnotherPage() {
    // Redirecionamento para a outra página no mesmo pacote
    window.location.href = 'posts';
}

