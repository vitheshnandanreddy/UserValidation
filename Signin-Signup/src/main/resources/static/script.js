function togglePassword(id) {
  const input = document.getElementById(id);
  input.type = input.type === 'password' ? 'text' : 'password';
}

function switchForm() {
  document.getElementById('signin').classList.toggle('hidden');
  document.getElementById('signup').classList.toggle('hidden');
}

function handleForgotPassword() {
  alert('Redirect to password reset page (To be implemented)');
}

// REGISTER
function registerUser() {
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const phone = document.getElementById('phone').value;
  const password = document.getElementById('signupPass').value;

  fetch('http://localhost:9090/register', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email, phone, password })
  })
    .then(res => res.text())
    .then(msg => alert(msg))
    .catch(err => console.error('Registration error:', err));
}

// LOGIN
function loginUser() {
  const identifier = document.getElementById('loginIdentifier').value;
  const password = document.getElementById('signinPass').value;

  fetch('http://localhost:9090/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ identifier, password })
  })
    .then(res => {
      if (res.ok) {
        window.location.href = 'welcome.html';
      } else {
        alert('Invalid credentials');
      }
    })
    .catch(err => console.error('Login error:', err));
}

// RESET PASSWORD
function resetPassword(event) {
  event.preventDefault(); // ✅ FIX 1: Prevent default form submission
  const identifier = document.querySelector('input[name=email]').value;
  const newPassword = prompt("Enter your new password:"); // ✅ FIX 2: Prompt user for new password

  if (!newPassword) {
    alert("Password reset cancelled.");
    return;
  }

  fetch('http://localhost:9090/reset', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ identifier, newPassword })
  })
    .then(res => res.text())
    .then(msg => alert(msg))
    .catch(err => console.error('Reset error:', err));
}
