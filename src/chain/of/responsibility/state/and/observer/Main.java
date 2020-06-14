package chain.of.responsibility.state.and.observer;

import chain.of.responsibility.state.and.observer.core.employees.Employee;
import chain.of.responsibility.state.and.observer.core.employees.ShipmentOfficerAbroad;
import chain.of.responsibility.state.and.observer.core.employees.ShipmentOfficerCity;
import chain.of.responsibility.state.and.observer.core.employees.ShipmentOfficerCountry;
import chain.of.responsibility.state.and.observer.core.observer.Observer;
import chain.of.responsibility.state.and.observer.core.observer.ObserverImpl;
import chain.of.responsibility.state.and.observer.core.shipments.AbroadShipment;
import chain.of.responsibility.state.and.observer.core.shipments.CityShipment;
import chain.of.responsibility.state.and.observer.core.shipments.CountryShipment;
import chain.of.responsibility.state.and.observer.core.shipments.Shipment;
import chain.of.responsibility.state.and.observer.logic.Engine;
import chain.of.responsibility.state.and.observer.output.ConsoleWriter;
import chain.of.responsibility.state.and.observer.output.OutputDevice;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        OutputDevice outputDevice = new ConsoleWriter();

        Employee shipmentOfficerCity = new ShipmentOfficerCity(null, outputDevice);
        Employee shipmentOfficerCountry = new ShipmentOfficerCountry(shipmentOfficerCity, outputDevice);
        Employee shipmentOfficerAbroad =  new ShipmentOfficerAbroad(shipmentOfficerCountry, outputDevice);
        shipmentOfficerCity.setNext(shipmentOfficerAbroad);

        Shipment shipment = new AbroadShipment();
        Shipment shipment2 = new AbroadShipment();
        Shipment shipment3 = new CityShipment();
        Shipment shipment4 = new AbroadShipment();
        Shipment shipment5 = new CityShipment();
        Shipment shipment6 = new CountryShipment();
        Shipment shipment7 = new AbroadShipment();
        Shipment shipment8 = new CountryShipment();

        Observer observer = new ObserverImpl(outputDevice);
        observer.setSubject(shipmentOfficerCity);
        observer.setSubject(shipmentOfficerCountry);
        observer.setSubject(shipmentOfficerAbroad);

        shipmentOfficerCity.register(observer);
        shipmentOfficerCountry.register(observer);
        shipmentOfficerAbroad.register(observer);

        Engine engine = new Engine(
                shipmentOfficerCountry,
                new ArrayList<Shipment>(Arrays.asList(shipment, shipment2, shipment3, shipment4, shipment5, shipment6, shipment7, shipment8)),
                outputDevice,
                observer
        );

        engine.run();


    }
}
