import {Entity, model, property} from '@loopback/repository';

@model({settings: {strict: false}})
export class Electores extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  id?: number;

  @property({
    type: 'string',
    required: true,
  })
  nombre: string;

  @property({
    type: 'string',
    required: true,
  })
  apellido_paterno: string;

  @property({
    type: 'string',
    required: true,
  })
  apellido_materno: string;

  @property({
    type: 'string',
    required: true,
  })
  direccion: string;

  @property({
    type: 'string',
    required: true,
  })
  dni: string;

  @property({
    type: 'boolean',
    required: true,
  })
  voto: boolean;

  // Define well-known properties here

  // Indexer property to allow additional data
  // eslint-disable-next-line @typescript-eslint/no-explicit-any

  constructor(data?: Partial<Electores>) {
    super(data);
  }
}

export interface ElectoresRelations {
  // describe navigational properties here
}

export type ElectoresWithRelations = Electores & ElectoresRelations;
