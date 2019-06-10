import {TopPartyAddress} from './top-party-address';

export interface TopChildSr {

  documentNumber: number;
  typeOfSr: string;
  pon: string;
  orderNumber: string;
  ban: string;
  focDate: string;
  address: TopPartyAddress;

}
