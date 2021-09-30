export interface Estancia {
    id: number;
    idTipoEstancia: number;
    nombreTipoEstancia: string;
    ref: string;
    planta: number;
    puerta: number;
    plazas: number;
    superficie: number;
    nombre: string;
    minibar: boolean;
    aireacondicionado: boolean;
    parking: boolean;
    jacuzzi: boolean;
    disponible: boolean;
    complementos: string;
}