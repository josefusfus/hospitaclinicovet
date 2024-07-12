// src/main/resources/static/js/main.js

document.addEventListener('DOMContentLoaded', () => {
    const mascotaForm = document.getElementById('form-crear-mascota');
    const mascotaList = document.getElementById('mascota-list');
    const ingresoList = document.getElementById('ingreso-list');

    const API_URL = '/hospitalclinicovet-api';

    mascotaForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const formData = new FormData(mascotaForm);
        const data = {
            especie: formData.get('especie'),
            raza: formData.get('raza'),
            edad: formData.get('edad'),
            codigoIdentificacion: formData.get('codigoIdentificacion'),
            dniResponsable: formData.get('dniResponsable')
        };

        try {
            const response = await fetch(`${API_URL}/mascota`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            const newMascota = await response.json();
            addMascotaToList(newMascota);
        } catch (error) {
            console.error('Error al crear mascota:', error);
        }
    });

    async function fetchMascotas() {
        try {
            const response = await fetch(`${API_URL}/mascota`);
            const mascotas = await response.json();
            mascotas.forEach(addMascotaToList);
        } catch (error) {
            console.error('Error al obtener mascotas:', error);
        }
    }

    async function fetchIngresos() {
        try {
            const response = await fetch(`${API_URL}/ingreso`);
            const ingresos = await response.json();
            ingresos.forEach(addIngresoToList);
        } catch (error) {
            console.error('Error al obtener ingresos:', error);
        }
    }

    function addMascotaToList(mascota) {
        const li = document.createElement('li');
        li.textContent = `${mascota.especie} - ${mascota.raza}`;
        mascotaList.appendChild(li);
    }

    function addIngresoToList(ingreso) {
        const li = document.createElement('li');
        li.textContent = `Mascota ID: ${ingreso.mascota.id} - Estado: ${ingreso.estado} - Fecha Alta: ${ingreso.fechaAltaIngreso}`;
        ingresoList.appendChild(li);
    }

    fetchMascotas();
    fetchIngresos();
});
