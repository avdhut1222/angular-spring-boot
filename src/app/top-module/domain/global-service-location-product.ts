import {ValueLabelModel} from './value-label-model';
import {LocationQuery} from './location-query';

export interface GlobalServiceLocationProduct {
  itemAlias: string;
  itemAliasSuf: number;
  activityCdText: string;
  servItemDesc: string;
  valueLabels: ValueLabelModel[];
  primaryLocations: LocationQuery[];
  secondaryLocations: LocationQuery[];
  orderServiceLocations: LocationQuery[];

}
